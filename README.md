# Application startup 

1. Clone repo:
   `git clone https://github.com/setevoy2/keygrav.git`
2. Start minikube:
   `minikube start`
3. Create deployment:
   `kubectl create -f ci/keygrav.yml`
4. Start service: 
   `kubectl expose deployment keygrav --type=NodePort`
5. Check it with curl:
   `curl $(minikube service keygrav --url)`

# Project description 

All build files located in the [ci](https://github.com/setevoy2/keygrav/tree/master/ci) directory:

- [keygrav.yml](ci/keygrav.yml) - pods deploy config

- [jenkins.groovy](ci/jenkins.groovy) - Jenkins pipeline plugin's build script (functions only)

- [keybuild.groovy](ci/keybuild.groovy) - Jenkins build script (build&&push image to the DockerHub)

- [Dockerfile](Dockerfile) in the root - to build images.

## Links

**DockerHub** repo: https://hub.docker.com/r/setevoy/keygrav/

**Jenkins** CI: http://keyjenkins.setevoy.org.ua/job/KeyGravPoC/ (_In order to access Jenkin's host - please, provide me your IP (to add it to the Jenkin's EC2 security group rules)  and use credentials from an email_)

## Questions

> how you would handle data persistence of the grav container in the future.

If Grav have ability to use persistent storage (and it have, judging the [Docker-Grav image's documentation] (https://hub.docker.com/r/garywiz/docker-grav/)) - then an AWS EFS directory (from an AWS EBS volume) can be mounted to the Kubernetes cluster and then PersistentVolumes configured to attach it to the containers.

I also added few points related to the deployment in the `kuberDeploy()` function of the [jenkins.groovy](ci/jenkins.groovy#L20) build script.
But again - not sure how "elegant" they are, as this is my first Kubernetes experience.

I also described my build process in my blog, if no objections (in rus), it's available [here>>>](https://rtfm.co.ua/kubernetes-zapusk-gravl-v-minikube/).

