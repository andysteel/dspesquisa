import React from 'react';
import { Text, StyleSheet } from 'react-native';
import { GamePlatform } from './types';
import { RectButton } from 'react-native-gesture-handler';
import { FontAwesome5 as Icon } from '@expo/vector-icons';

type Props = {
    platform: GamePlatform,
    onChange:(platform: GamePlatform) => void,
    icon: string,
    activePlatform?: GamePlatform
}

const PlatformCard = ({platform, onChange, icon, activePlatform}: Props) => {

    const isActive = platform === activePlatform;
    const backgroundColor = isActive ? '#fAd7c8' : '#fff'
    const textColor = isActive ? '#ed7947' : '#9e9e9e'

    return (
        <RectButton
            style={[styles.platformCard, {backgroundColor}]}
            onPress={() => onChange(platform)}
        >
            <Icon name={icon} size={60} color={textColor} ></Icon>
            <Text style={[styles.platformCardText, {color: textColor}]}>
                {platform === 'PLAYSTATION' ? 'PS' : platform}
            </Text>
        </RectButton>
    );
}

export default PlatformCard;

const styles = StyleSheet.create({
    platformCard: {
      paddingTop: 30,
      paddingBottom: 20,
      width: '30%',
      backgroundColor: '#FFF',
      borderRadius: 10,
      justifyContent: 'center',
      alignItems: 'center'
    },
    platformCardText: {
      marginTop: 40,
      color: '#9E9E9E',
      fontSize: 24,
      fontFamily: "Play_700Bold",
      textAlign: 'center'
    },
  });