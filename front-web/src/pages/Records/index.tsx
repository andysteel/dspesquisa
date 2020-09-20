import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { RecordsResponse } from './types';
import { formatDate } from './helpers';
import './styles.css';
import Pagination from './Pagination';
import Filters from '../../components/Filters';
import { BASE_URL } from '../../config/url.config';

const Records = () => {

    //useState - Observer for listenning changes
    const [recordsResponse, setRecordsResponse] = useState<RecordsResponse>();
    const [activePage, setActivePage] = useState(0);
    
    //useEffect - init data for the component 
    useEffect(() => {
        axios.get(`${BASE_URL}/records?linesPerPage=12&page=${activePage}`)
            .then(response => setRecordsResponse(response.data));
    }, [activePage]) 

    return (
        <div className="page-container">
            <Filters 
                link="/charts"
                textLink="VER GRÁFICOS"
            />
            <table className="records-table" cellPadding="0" cellSpacing="0"> 
                <thead>
                    <tr>
                        <th>DATA</th>
                        <th>NOME</th>
                        <th>IDADE</th>
                        <th>PLATAFORMA</th>
                        <th>GÊNERO</th>
                        <th>TÍTULO DO GAME</th>
                    </tr>
                </thead>
                <tbody>
                    {recordsResponse?.content.map(record => (
                        <tr key={record.id} >
                            <td>{formatDate(record.moment)}</td>
                            <td>{record.name}</td>
                            <td>{record.age}</td>
                            <td className="text-secondary" >{record.gamePlatform}</td>
                            <td>{record.genreName}</td>
                            <td className="text-primary">{record.gameTitle}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <Pagination 
                totalPages={recordsResponse?.totalPages}
                activePage={activePage}
                goToPage={(item: number) => setActivePage(item)}
            />
        </div>
    );
}

export default Records;