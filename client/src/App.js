import React, {Component} from 'react';
import FolderList from './AlbumList'
import 'whatwg-fetch';

class App extends Component {

    constructor() {
        super();
    }

    render() {
        return (
            <div>
                <FolderList albums={this.props.albums}/>
            </div>
        );
    }
}

export default App;
