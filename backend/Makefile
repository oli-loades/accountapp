.PHONY = docker_up docker_destroy

NAME = accountapp
USER = oli


docker_start_accountapp:
	@mvn clean install
	docker build -t ${USER}/${NAME} .
	@docker run -p 8182:8182 --name ${NAME} --link accountMySQL:mysql -d ${USER}/${NAME}

docker_destroy_accountapp:
	@docker stop ${NAME}
	@docker rm ${NAME}

docker_start_mysql:
	@docker run --name accountMySQL -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=accountapp -e MYSQL_USER=sa -e MYSQL_PASSWORD=sa -d mysql:5.7

docker_destroy_all:
	@docker stop $(shell docker ps -aq)
	@docker rm $(shell docker ps -aq)


