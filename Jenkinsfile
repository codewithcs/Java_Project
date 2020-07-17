#!/usr/bin/groovy
pipeline {
    agent any
    stages {
        stage('Build') {
            steps{
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Test'){
            steps{
                sh 'mvn test'
            }

            post {
                always {
                    junit allowEmptyResults: true, testResults:'target/surefire-reports/*.xml'
                }
            }
        }
    }

    post{
        success{
            script{
                this.notifyStash("SUCCESS")
            }
            archiveArtifacts 'target/*.jar'
        }
        unstable{
            script{
                this.notifyStash("UNSTABLE")
            }
        }
        failure{
            script{
                this.notifyStash("FAILURE")
            }
        }
        always {
            emailext to: "ddiruscio@murex.com",
                    recipientProviders: [requestor()],
                    replyTo: "ddiruscio@murex.com",
                    subject: "[${env.JOB_NAME}] ${currentBuild.currentResult}",
                    body: '${SCRIPT,  template="groovy-html.template"}'
        }
    }
}

def notifyStash(String state) {
    currentBuild.result = state
    step([$class: 'StashNotifier'])
}