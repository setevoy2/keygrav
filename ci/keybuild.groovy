#!/usr/bin/env groovy

node {

    git branch: "${BRANCH}", url: "${BUILDREPOURL}"

    def build = load 'ci/jenkins.groovy'

    build.dockerBuild()
//	build.kuberDeploy()
}
