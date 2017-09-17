import React, {Component} from 'react';
import AlbumList from './AlbumList'
import AddButton from './AddButton'
import {SERVER_URL} from './config';
import 'whatwg-fetch';

class App extends Component {

    constructor() {
        super();
        this.state = {
            albums: []
        }
    };

    componentDidMount() {
        fetch(SERVER_URL + '/albums')
            .then(r => r.json())
            .then(json => this.setState({albums: json}))
            .catch(error => console.error('Error connecting to server: ' + error));
    }

    render() {
        return (
            <div>
                <AlbumList albums={this.state.albums}/>
                <AddButton/>
            </div>
        );
    }
}

export default App;
