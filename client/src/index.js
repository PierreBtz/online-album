import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import './css/App.css';
import './css/grails.css';
import './css/main.css';


const ALBUMS = [
    {name: 'Team 1', description: 'This is the album of the first team'},
    {name: 'Team 2', description: 'This is the album of the second team'}
];

ReactDOM.render(
    <App albums={ALBUMS}/>,
    document.getElementById('root')
);
