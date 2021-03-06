import React from 'react';
import ReactDOM from 'react-dom';

import App from './App';
import AddAlbum from './AddAlbum';
import Album from './Album';

import {
    BrowserRouter as Router,
    Route
} from 'react-router-dom'

import './css/App.css';
import './css/grails.css';
import './css/main.css';

ReactDOM.render(
    <Router>
        <div>
            <Route exact path="/" component={App}/>
            <Route path="/add" component={AddAlbum}/>
            <Route path="/album" component={Album}/>
        </div>
    </Router>,
    document.getElementById('root')
);
