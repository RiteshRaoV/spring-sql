pipeline {
    agent any
    
    stages {
        stage('Clean Workspace') {
            steps {
                deleteDir()
            }
        }
        stage('Checkout') {
            steps {
                bat 'git clone -b main https://github.com/RiteshRaoV/spring-sql.git'
            }
        }
        stage('Build') {
            steps {
                dir('spring-sql') {
                    bat 'mvn clean package'
                }
            }
        }
        stage('Deploy to Desktop') {
            steps {
                dir('spring-sql/target') {
                    bat 'xcopy /Y sql-0.0.1-SNAPSHOT.jar "C:\\Users\\rithe\\Desktop"'
                }
            }
        }
        stage('Run Application') {
            steps {
                bat 'cd "C:\\Users\\rithe\\Desktop" && java -jar sql-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}
