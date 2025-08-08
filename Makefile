up:
	kind create cluster --config=kind-config.yaml
	kubectl apply -f ./deploy/ingress-nginx.yaml
	sleep 10
	kubectl wait --namespace ingress-nginx --for=condition=ready pod --selector=app.kubernetes.io/component=controller --timeout=90s
	kubectl apply -f ./deploy/mongo_db_deploy.yaml
	kubectl apply -f ./deploy/kafka_deploy.yaml
	kubectl apply -f ./deploy/deploy.yaml

down:
	kind delete cluster

restart: down up