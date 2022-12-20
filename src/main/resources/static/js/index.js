import ChessBoard from "./chessboard.js"

import Client from "./client.js"

window.addEventListener('load', (event) => {

    /*Client.post('js/data.json', {}, data => {
        let chessBoard = new ChessBoard('container', data.side)
    })*/
    let chessBoard = new ChessBoard('container', "black")
})