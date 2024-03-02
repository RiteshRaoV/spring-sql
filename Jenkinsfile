pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                // Checkout the 'main' branch
                git branch: 'main', url: 'https://github.com/RiteshRaoV/spring-sql.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        
        stage('Deploy to Localhost') {
            steps {
                // Copy the JAR file to the deploy directory
                sh 'cp target/your-app.jar /path/to/deploy/directory'
            }
        }
    }
}
