mvn clean install
cd web && ng build --aot --prod --output-hashing none && cd ..
docker build -t webapp:build .
docker build -t postgres:build ./db
docker build -t webapp-client:build ./web