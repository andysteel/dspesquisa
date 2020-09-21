import React, { useState, useEffect } from 'react';
import { View, TextInput, StyleSheet, Text, Alert } from 'react-native';
import Header from '../../components/Header';
import PlatformCard from '../../components/PlatformCard';
import { GamePlatform } from '../../components/PlatformCard/types';
import RNPickerSelect from 'react-native-picker-select';
import { FontAwesome5 as Icon } from '@expo/vector-icons';
import axios from 'axios';
import { Game, Interviewee } from './types';
import { RectButton } from 'react-native-gesture-handler';

const placeHolder = {
    label: 'Selecione o game',
    value: ''
}

const BASE_URL = 'https://dspesquisa-andysteel.herokuapp.com';

const mapSelectedValues = (games: Game[]) => {
    return games.map(game => ({
        ...game,
        label: game.title,
        value: game.id
    }))
}

const CreateRecord = () => {

    const [platform, setPlatform] = useState<GamePlatform>();
    const [selectedGame, setSelectedGame] = useState('');
    const [allGames, setAllGames] = useState<Game[]>([]);
    const [filteredGames, setFilteredGames] = useState<Game[]>([]);
    const [name, setName] = useState<string>('');
    const [age, setAge] = useState<string>('');

    const handleChangePlatform = (selected: GamePlatform) => {
        setPlatform(selected);
        const gamesByPlatform = allGames.filter(game => game.platform === selected);
        setFilteredGames(gamesByPlatform);
    }

    const handleSubmit = () => {
        const interviewee: Interviewee = { name, age };
        const payload = { ...interviewee, gameId: selectedGame };
        axios.post(`${BASE_URL}/records`, payload)
            .then(() => {
                Alert.alert('Resposta a pesquisa salva com sucesso !');
                setName('');
                setAge('');
                setSelectedGame('');
                setPlatform(undefined);
            })
            .catch(() => Alert.alert('Erro ao tentar salvar pesquisa !'));
    }

    useEffect(() => {
        axios.get(` ${BASE_URL}/games`)
            .then(response => {
                const selectValues = mapSelectedValues(response.data);
                setAllGames(selectValues)
            })
            .catch(() => Alert.alert('Erro ao tentar listar os games !'));
    },[])

    return (
        <>
            <Header />
            <View style={styles.container}>
                <TextInput style={styles.inputText} 
                    placeholder="Nome"
                    placeholderTextColor="#9E9E9E"
                    onChangeText={text => setName(text)}
                    value={name}
                />
                <TextInput style={styles.inputText} 
                    keyboardType="numeric"
                    maxLength={3}
                    placeholder="Idade"
                    placeholderTextColor="#9E9E9E"
                    onChangeText={text => setAge(text)}
                    value={age}
                />
                <View style={styles.platformContainer}>
                    <PlatformCard 
                        platform="PC" 
                        icon="laptop"
                        activePlatform={platform} 
                        onChange={handleChangePlatform}/>
                    <PlatformCard 
                        platform="XBOX"
                        icon="xbox"
                        activePlatform={platform}
                        onChange={handleChangePlatform}/>
                    <PlatformCard 
                        platform="PLAYSTATION"
                        icon="playstation" 
                        activePlatform={platform}
                        onChange={handleChangePlatform}/>
                </View>
                <RNPickerSelect
                    style={pickerSelectStyles}
                    Icon={() => {
                       return <Icon name="chevron-down" color="#9e9e9e" size={25} />
                    }}
                    placeholder={placeHolder}
                    onValueChange={value => {
                        setSelectedGame(value);
                    }}
                    value={selectedGame}
                    items={filteredGames}
                >

                </RNPickerSelect>
                <View style={styles.footer}>
                    <RectButton 
                        onPress={handleSubmit}
                        style={styles.button}>
                        <Text style={styles.buttonText}>
                            Salvar
                        </Text>
                    </RectButton>
                </View>
            </View>
        </>
    )
}

export default CreateRecord;

const pickerSelectStyles = StyleSheet.create({
    inputIOS: {
      fontSize: 16,
      paddingVertical: 12,
      paddingHorizontal: 20,
      backgroundColor: '#FFF',
      borderRadius: 10,
      color: '#ED7947',
      paddingRight: 30,
      fontFamily: "Play_700Bold",
      height: 50
    },
    inputAndroid: {
      fontSize: 16,
      paddingVertical: 12,
      paddingHorizontal: 20,
      backgroundColor: '#FFF',
      borderRadius: 10,
      color: '#ED7947',
      paddingRight: 30,
      fontFamily: "Play_700Bold",
      height: 50
    },
    placeholder: {
      color: '#9E9E9E',
      fontSize: 16,
      fontFamily: "Play_700Bold",
    },
    iconContainer: {
      top: 10,
      right: 12,
    }
});

const styles = StyleSheet.create({
    container: {
      marginTop: '15%',
      paddingRight: '5%',
      paddingLeft: '5%',
      paddingBottom: 50
    },
    inputText: {
      height: 50,
      backgroundColor: '#FFF',
      borderRadius: 10,
      color: '#ED7947',
      fontFamily: "Play_700Bold",
      fontSize: 16,
      paddingLeft: 20,
      marginBottom: 21
    },
    platformContainer: {
      marginBottom: 20,
      flexDirection: 'row',
      justifyContent: 'space-between',
    },
    footer: {
      marginTop: '15%',
      alignItems: 'center',
    },
    button: {
      backgroundColor: '#00D4FF',
      flexDirection: 'row',
      borderRadius: 10,
      height: 60,
      width: '100%',
      alignItems: 'center',
      justifyContent: 'center'
    },
    buttonText: {
      fontFamily: "Play_700Bold",
      fontWeight: 'bold',
      fontSize: 18,
      color: '#0B1F34',
    }
});