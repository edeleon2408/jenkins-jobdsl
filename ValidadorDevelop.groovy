validador_otp_api_multibranch = "dev-validador-otp-api/otp-api"
validador_admin_otp_multibranch = "dev-validador-otp-api/otp-admin"
validador_preguntas_api_multibranch = "dev-validador-preguntas-api/preguntas-api"

repo_validador_otp_api = "";
repo_validador_admin_otp = "https://github.com/edeleon2408/validador-api-otp.git";
repo_validador_preguntas_api = "";

folder_name_validador_otp = "dev-validador-otp-api"
folder_name_validador_preguntas_api = "dev-validador-preguntas-api"

view_name_develop = "Develop"
//view_name_api_preguntas = "Api-preguntas"

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
            id('dev-validador-otp-api-id')
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
            id('dev-validador-admin-otp-id')
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
            id('dev-validador-preguntas-api-id')
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
                regex(/.*dev.*/)
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

//Vista para el Proyecto Api Preguntas
//listView(view_name_api_preguntas){
//        description('Vista que contendrá todas las tareas del proyecto Api preguntas')
//        jobs {
//                regex(/.*preguntas.*/)
//        }
//        columns {
//                status()
//                weather()
//                name()
//                lastSuccess()
//                lastFailure()
//                lastDuration()
//                buildButton()
//        }
//}
