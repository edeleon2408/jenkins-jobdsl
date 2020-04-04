project_name = "jenkins-docker-war-pipeline"
repo = "https://github.com/edeleon2408/jenkins-docker-war.git";
repo_name = "jenkins-docker-war"

pipelineJob(project_name){
	definition{
		triggers{
			scm('* * * * *')
		}
		
		cpsScm{
			scm{
				git{
					remote{
						name(repo_name)
						url(repo)
					}
				}
				scriptPath("Jenkinsfile")
			}
		}
	}
}