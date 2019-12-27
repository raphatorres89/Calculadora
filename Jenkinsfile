pipeline {
  agent any
  stages {
        stage('Tests') {
            steps {
                script {
                    try {
                        sh './gradlew clean test --no-daemon'
                    } finally {
                        junit '**/build/test-results/test/*.xml' //make the junit test results available in any case (success & failure)
                    }
                }
            }
        }
        stage('Build') {
            steps {
                script {
                    try {
                        sh './gradlew clean build'
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    try {
                        sh 'java -jar build/libs/calculadora-0.0.1-SNAPSHOT.jar'
                    }
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
