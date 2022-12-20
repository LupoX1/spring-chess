import Client from "./client.js"

const pieces = [
    {
        id: 0,
        type: 'rook',
        side: 'black',
        row: 8,
        col: 'a'
    },
    {
        id: 1,
        type: 'knight',
        side: 'black',
        row: 8,
        col: 'b'
    },
    {
        id: 2,
        type: 'bishop',
        side: 'black',
        row: 8,
        col: 'c'
    },
    {
        id: 3,
        type: 'queen',
        side: 'black',
        row: 8,
        col: 'd'
    },
    {
        id: 4,
        type: 'king',
        side: 'black',
        row: 8,
        col: 'e'
    },
    {
        id: 5,
        type: 'bishop',
        side: 'black',
        row: 8,
        col: 'f'
    },
    {
        id: 6,
        type: 'knight',
        side: 'black',
        row: 8,
        col: 'g'
    },
    {
        id: 7,
        type: 'rook',
        side: 'black',
        row: 8,
        col: 'h'
    },
    {
        id: 8,
        type: 'pawn',
        side: 'black',
        row: 7,
        col: 'a'
    },
    {
        id: 9,
        type: 'pawn',
        side: 'black',
        row: 7,
        col: 'b'
    },
    {
        id: 10,
        type: 'pawn',
        side: 'black',
        row: 7,
        col: 'c'
    },
    {
        id: 11,
        type: 'pawn',
        side: 'black',
        row: 7,
        col: 'd'
    },
    {
        id: 12,
        type: 'pawn',
        side: 'black',
        row: 7,
        col: 'e'
    },
    {
        id: 13,
        type: 'pawn',
        side: 'black',
        row: 7,
        col: 'f'
    },
    {
        id: 14,
        type: 'pawn',
        side: 'black',
        row: 7,
        col: 'g'
    },
    {
        id: 15,
        type: 'pawn',
        side: 'black',
        row: 7,
        col: 'h'
    },
    {
        id: 16,
        type: 'rook',
        side: 'white',
        row: 1,
        col: 'a'
    },
    {
        id: 17,
        type: 'knight',
        side: 'white',
        row: 1,
        col: 'b'
    },
    {
        id: 18,
        type: 'bishop',
        side: 'white',
        row: 1,
        col: 'c'
    },
    {
        id: 19,
        type: 'queen',
        side: 'white',
        row: 1,
        col: 'd'
    },
    {
        id: 20,
        type: 'king',
        side: 'white',
        row: 1,
        col: 'e'
    },
    {
        id: 21,
        type: 'bishop',
        side: 'white',
        row: 1,
        col: 'f'
    },
    {
        id: 22,
        type: 'knight',
        side: 'white',
        row: 1,
        col: 'g'
    },
    {
        id: 23,
        type: 'rook',
        side: 'white',
        row: 1,
        col: 'h'
    },
    {
        id: 24,
        type: 'pawn',
        side: 'white',
        row: 2,
        col: 'a'
    },
    {
        id: 25,
        type: 'pawn',
        side: 'white',
        row: 2,
        col: 'b'
    },
    {
        id: 26,
        type: 'pawn',
        side: 'white',
        row: 2,
        col: 'c'
    },
    {
        id: 27,
        type: 'pawn',
        side: 'white',
        row: 2,
        col: 'd'
    },
    {
        id: 28,
        type: 'pawn',
        side: 'white',
        row: 2,
        col: 'e'
    },
    {
        id: 29,
        type: 'pawn',
        side: 'white',
        row: 2,
        col: 'f'
    },
    {
        id: 30,
        type: 'pawn',
        side: 'white',
        row: 2,
        col: 'g'
    },
    {
        id: 31,
        type: 'pawn',
        side: 'white',
        row: 2,
        col: 'h'
    }
]

export default class ChessBoard {
    constructor(containerId, side) {
        this.createBoard(containerId, side)

        pieces.forEach(piece => {
            let cell = document.querySelector('#' + piece.col + '-' + piece.row)
            cell.append(this.createPiece(piece))
        })

        const board = document.querySelector("#chessboard")
        board.addEventListener('dragenter', this.dragEnter)
        board.addEventListener('dragover', this.dragOver, false)
        board.addEventListener('dragleave', this.dragLeave)
        board.addEventListener('drop', this.drop)

        document.querySelector('#chessboard').classList.add(side)
    }

    createBoard(containerId, side) {
        const columns = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
        let headRow = document.createElement('tr')
        headRow.appendChild(document.createElement('th'))
        let footRow = document.createElement('tr')
        footRow.appendChild(document.createElement('th'))
        columns.forEach(col => {
            let thHead = document.createElement('th')
            thHead.textContent = col
            headRow.appendChild(thHead)

            let thFoot = document.createElement('th')
            thFoot.textContent = col
            footRow.appendChild(thFoot)
        })
        headRow.appendChild(document.createElement('th'))
        footRow.appendChild(document.createElement('th'))

        let thead = document.createElement('thead')
        thead.appendChild(headRow)

        let tfoot = document.createElement('tfoot')
        tfoot.appendChild(footRow)

        let tbody = document.createElement('tbody')
        for (let r = 8; r > 0; r--) {
            let row = (side === 'black' ? 9 - r : r)
            let tr = document.createElement('tr')
            let thBefore = document.createElement('th')
            thBefore.textContent = row
            tr.appendChild(thBefore)

            columns.forEach(col => {
                let div = document.createElement('div')
                div.id = col + '-' + row
                div.classList.add('board-cell')
                div.setAttribute('draggable', false)

                let td = document.createElement('td')
                td.appendChild(div)
                tr.appendChild(td)
            })

            let thAfter = document.createElement('th')
            thAfter.textContent = row
            tr.appendChild(thAfter)
            tbody.appendChild(tr)
        }

        let table = document.createElement('table')
        table.id = 'chessboard'
        table.classList.add('shadow-' + side)
        table.appendChild(thead)
        table.appendChild(tbody)
        table.appendChild(tfoot)

        let captureZone1 = document.createElement('div')
        captureZone1.classList.add('capture')
        captureZone1.classList.add('shadow-' + side)

        let captureZone2 = document.createElement('div')
        captureZone2.classList.add('capture')
        captureZone2.classList.add('shadow-' + side)

        let container = document.querySelector('#' + containerId)
        container.innerHTML = ''
        container.appendChild(captureZone1)
        container.appendChild(table)
        container.appendChild(captureZone2)
        document.body.classList.add(side)
    }

    dragStart(e) {
        e.dataTransfer.setData('text/plain', e.target.id)
        e.dataTransfer.effectAllowed = 'move'
        e.target.classList.add('drag-over')
    }

    drag(e) {
    }

    dragEnd(e) {
        e.target.classList.remove('drag-over')
    }

    dragOver(e) {
        e.preventDefault()
        e.dataTransfer.dropEffect = 'move'
    }

    dragEnter(e) {
        console.log('dragEnter', e.target.tagName)

        let target = e.target
        if (target.tagName.toLowerCase() === 'td') {
            target = target.querySelector('.board-cell')
        }
        if(target.classList.contains('board-cell')){
            target.classList.add('drag-over')
        }
        console.log(target)
    }

    dragLeave(e) {
        console.log('dragLeave', e.target.tagName)
        
        let target = e.target
        if (target.tagName.toLowerCase() === 'td') {
            target = target.querySelector('.board-cell')
        }
        if(target.classList.contains('board-cell')){
            target.classList.remove('drag-over')
        }
        console.log(target)
    }

    drop(e) {
        const id = e.dataTransfer.getData('text/plain')
        const draggable = document.querySelector('#' + id)
        
        let target = e.target
        if (target.tagName.toLowerCase() === 'td') {
            target = target.querySelector('.board-cell')
        }

        if(target.classList.contains('board-cell')){
            target.appendChild(draggable)
            target.classList.remove('drag-over')
        }
      
        //draggable.classList.remove('hide')
    }

    createPiece(data) {
        let image = new Image()
        image.id = 'p' + data.id
        image.src = 'images/' + data.side + '_' + data.type + '.png'
        image.setAttribute('draggable', true)
        image.classList.add('chess-piece')
        image.addEventListener('dragstart', this.dragStart)
        image.addEventListener('drag', this.drag)
        image.addEventListener('dragend', this.dragEnd)
        return image
    }
}