#!/usr/bin/env groovy

def dockerBuild () {

    stage ('Docker build') {

        sh 'ls -l'

        withDockerRegistry(registry: [credentialsId: 'setevoy-docker-hub']){
            docker.build("setevoy/keygrav:${env.BUILD_NUMBER}").push()
        }
    }
}

def kuberDeploy () {

	stage ('Deploy') {

		/* As this is PoC and we have no Dev/QA/etc environments - deploy wasn't done.
           Possible soultions
           1:
           - update keygrav.yml in repo with new :tag
           - copy to the Master host
           - kubectl apply -f keygrav.yml
           2:
           - SSH to the Master host and exec `kubectl set image deployment/keygrav keygrav=setevoy/keygrav:${env.BUILD_NUMBER}`
         */
    }
}
