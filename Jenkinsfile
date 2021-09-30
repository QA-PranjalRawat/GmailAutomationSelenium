pipeline{
    agent any

    tools{
        maven "3.3.9"
    }

    stages{
        stage("Build"){
            steps{
                sh "mvn -version"
                sh "mvn clean install"
            }
        }
    }
}