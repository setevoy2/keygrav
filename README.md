
1. Clone repo:
   git clone https://github.com/setevoy2/keygrav.git`
2. Start minikube:
   minikube start
3. Create deployment:
   kubectl create -f ci/keygrav.yml
4. Start service: kubectl expose deployment keygrav --type=NodePort
5. Check it with curl:
   curl $(minikube service keygrav --url)
