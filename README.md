# Visca client

## Running
```$xslt
java -jar <path_to_jar> <port_name>

Example:
java -jar ./target/visca.jar COM1

If <port_name> is not given then program launches with stub connection.
```


## Getting started

### Basic commands
```$xslt
$ move-up

$ zoom-tele dest=all

$ sleep time=2

# ...and many more
```

### Defining and executing sequence command
```$xslt
$ seq name=foobar
 foobar$ move-home
 foobar$ move-right dest=2
 foobar$ sleep time=2
 foobar$ zoom-wide
 foobar$ clear-all
 foobar$ end-seq
 
$ execute-seq name-foobar
```

### Executing commands through HTTP
Starting server:
```$xslt
$ start-http port=8000
```

Executing commands:
```$xslt
POST localhost:8000/command?cmd=move-up

POST localhost:8000/command?cmd=zoom-tele&dest=3

POST localhost:8000/command?cmd=sleep&time=3

...and many more
```

Stopping server:
```$xslt
$ stop-http
```

### Web client
Start server (on port 8000 by default) and type `http://localhost:8000` in your browser.
