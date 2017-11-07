docker rm -f sse
docker run -d -p 8080:8080 -p 4848:4848 --name sse com.yard42/sse 
