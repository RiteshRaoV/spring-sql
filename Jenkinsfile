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
                    bat 'copy C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\test1\\spring-sql\\target\\sql-0.0.1-SNAPSHOT.jar.original "C:\\Users\\rithe\\Desktop"'
                }
            }
        }
    }
}
