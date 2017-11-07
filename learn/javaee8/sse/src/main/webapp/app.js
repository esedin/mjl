class Events {
    constructor() {
        this.events = new EventSource("http://pc-esed:8080/sse/resources/beats");
        this.events.onopen = (e) => console.log(e);
        this.events.onmessage = ({data}) => console.log(data);
    }
}

new Events();
