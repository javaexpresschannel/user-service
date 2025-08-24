pipeline {
    agent any

    tools {
        maven "MAVEN"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/javaexpresschannel/user-service.git'

            }
        }

        stage('Compile') {
            steps {
                sh "mvn clean compile"
            }
        }

        stage('Build') {
            steps {
                sh "mvn package"
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t javaexpress/user-service:latest .'
            }
        }

        stage('Docker Login') {
            steps {
                withCredentials([string(credentialsId: 'DOCKER_HUB_PASSWORD', variable: 'PASSWORD')]) {
                    sh 'docker login -u javaexpress -p $PASSWORD'
                }
            }
        }

        stage('Docker Push') {
            steps {
                sh 'docker push javaexpress/user-service:latest'
            }
        }
    }
}
