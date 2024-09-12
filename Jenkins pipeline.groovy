pipeline{
    agent any
    parameters {
        booleanParam(name: "Build_Jar", defaultValue: false)
    }
    enviroment {
        AWS_DEFAULT_REGION="Region like eu_west"
    }
    stages{
        stage('GIT Checkout'){
            steps{
                sh label:'',
            }
        }
    }


}