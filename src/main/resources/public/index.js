function executeCommand(command) {
    let url = buildUrl(command, {dest: getDestination()});
    fetch(url, {method: 'POST'})
        .then(response => response.text())
        .then(response => {
            document.getElementById('response-div').innerHTML = response;
        });
}

function getDestination() {
    return document.getElementById('destination-input').value;
}

function buildUrl(command, params) {
    const url = new URL(window.location.origin + '/command');
    url.searchParams.append('cmd', command);
    Object.keys(params).forEach(key => url.searchParams.append(key, params[key]));
    return url;
}