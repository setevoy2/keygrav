#!/usr/bin/env groovy

node {

    git branch: "${BRANCH}", url: "${BUILDREPOURL}"

    def build = load 'jenkins.groovy'

    build.dockerBuild()
//	build.kuberDeploy()
}
