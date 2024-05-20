# HW 04
Client-server currency rate provider

To start run the following gradle configs:
```
client-server -> build -> bootJar
```

Then start up docker-compose (while being in project root - `./client-server/`):
```shell
docker compose up
```

It might hiccup a little bit, might need to start some containers manually (`client` probably),
but then everything will work

You can access Grafana by opening http://localhost:3000
