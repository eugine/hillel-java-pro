docker run -d \
  -e POSTGRES_USER=hillel \
  -e POSTGRES_PASSWORD=hillel \
  -p 5432:5432 \
  -v java-pro-202307:/var/lib/postgresql/data \
  postgres:14.2
