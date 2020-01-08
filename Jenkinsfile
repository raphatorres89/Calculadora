pipeline {
  agent any
  stages {
        stage('Tests') {
            steps {
                script {
                    sh './gradlew clean test'
                }
            }
        }
        stage('Build') {
            steps {
                script {
                    sh './gradlew clean build'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    sh 'java -jar build/libs/calculadora-0.0.1-SNAPSHOT.jar'
                }
            }
        }
    }
    post {
        always {
            echo 'Processo finalizado'
        }
        success {
            echo 'SUCESSO!'
        }
        failure {
            echo 'ERRO!'
        }
        unstable {
            echo 'FINALIZADO COM INSTABILIDADE'
        }
    }
}
