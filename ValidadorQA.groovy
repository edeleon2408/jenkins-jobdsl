validador_otp_api_multibranch = "qa-validador-otp-api/otp-api"
validador_admin_otp_multibranch = "qa-validador-otp-api/otp-admin"
validador_preguntas_api_multibranch = "qa-validador-preguntas-api/preguntas-api"

repo_validador_otp_api = "";
repo_validador_admin_otp = "";
repo_validador_preguntas_api = "";

folder_name_validador_otp = "qa-validador-otp-api"
folder_name_validador_preguntas_api = "qa-validador-preguntas-api"

view_name_develop = "QA"

//Folder para el Proyecto Validador OTP
folder(folder_name_validador_otp){
        displayName(folder_name_validador_otp)
        description('Folder para proyectos de Validador OTP')
}

//Folder para el Proyecto Api Preguntas
folder(folder_name_validador_preguntas_api){
        displayName(folder_name_validador_preguntas_api)
        description('Folder para proyectos de Preguntas Api')
}

//Multibranch para el OTP API
multibranchPipelineJob(validador_otp_api_multibranch) {
    triggers {
        periodic(1)
    }
    branchSources {
        git {
            id('qa-validador-otp-api-id')
            remote(repo_validador_otp_api)
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

//Multibranch para Admin OTP
multibranchPipelineJob(validador_admin_otp_multibranch) {
    triggers {
        periodic(1)
    }
    branchSources {
        git {
            id('qa-validador-admin-otp-id')
            remote(repo_validador_admin_otp)
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

//Multibranch para Preguntas Api
multibranchPipelineJob(validador_preguntas_api_multibranch) {
    triggers {
        periodic(1)
    }
    branchSources {
        git {
            id('qa-validador-preguntas-api-id')
            remote(repo_validador_preguntas_api)
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

//Vista para los Proyectos del ambiente de desarrollo
listView(view_name_develop){
        description('Vista que contendrá todas las tareas del ambiente de desarrollo para cualquier proyecto')
        jobs {
                regex(/.*qa.*/)
        }
        columns {
                status()
                weather()
                name()
                lastSuccess()
                lastFailure()
                lastDuration()
                buildButton()
        }
}
