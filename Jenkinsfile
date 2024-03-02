pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                // Checkout the correct branch (replace 'main' with the actual branch name)
                bat 'git clone -b main https://github.com/RiteshRaoV/spring-sql.git'
            }
        }
        
        stage('Build') {
            steps {
                // Navigate into the project directory
                dir('spring-sql') {
                    // Build the project with Maven
                    bat 'mvn clean package'
                }
            }
        }
        
        stage('Deploy to Desktop') {
            steps {
                // Navigate into the project directory
                dir('spring-sql') {
                    // Copy the JAR file to the desktop
                    bat 'copy target\\your-app.jar %USERPROFILE%\\Desktop'
                }
            }
        }
    }
}
