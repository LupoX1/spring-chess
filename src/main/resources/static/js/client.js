const post = (url, data, handler) => {
    fetch(url, {
        headers : {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method : 'POST',
        body : JSON.stringify(data)
    })
    .then(response => response.json())
    .then(json =>{
        window.setTimeout(handler, 1000, json)
    })
    .catch(err => console.log(err))
}

const get = (url, data, handler) => {
    let request = new URL(url)
    request.search = new URLSearchParams(data).toString()

    fetch(request)
    .then(response => response.json())
    .then(handler)
    .catch(err => console.log(err))
}

const client = {
    post : post,
    get : get
}

export default client