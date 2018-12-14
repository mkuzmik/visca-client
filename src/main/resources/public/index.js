function executeCommand(command) {
    fetch(window.location.origin + `/command?cmd=${command}&dest=${getDestination()}${getSpeedParam()}`, {method: 'POST'})
        .then(response => response.text())
        .then(response => {
            document.getElementById('response-div').innerHTML = response;
        });
}

function getDestination() {
    return document.getElementById('destination-input').value;
}

function getSpeedParam() {
    let value = document.getElementById('speed-input').value;
    return value ? `&speed=${value}` : '';
}