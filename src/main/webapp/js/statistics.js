/**
 * Created by siiri on 26/04/15.
 */

function start() {
    var eventSource = new EventSource("PushServlet");

    eventSource.addEventListener('statUpdate', function(event) {
        document.getElementById('stats').innerHTML = event.data;
    }, false);
}

