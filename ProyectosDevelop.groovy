validador_otp_api_multibranch = "Validador-otp-api/otp-api"
validador_admin_otp_multibranch = "Validador-otp-api/otp-admin"
preguntas_api_multibranch = "Preguntas-api/preguntas-api"

repo_validador_otp_api = "";
repo_validador_admin_otp = "https://github.com/edeleon2408/validador-api-otp.git";
repo_preguntas_api = "";

folder_name_validador_otp = "Validador-otp-api"
folder_name_preguntas_api = "Preguntas-api"

view_name_develop = "Develop"
//view_name_api_preguntas = "Api-preguntas"

//Folder para el Proyecto Validador OTP
folder(folder_name_validador_otp){
        displayName(folder_name_validador_otp)
        description('Folder para proyectos de Validador OTP')
}

//Folder para el Proyecto Api Preguntas
folder(folder_name_preguntas_api){
        displayName(folder_name_preguntas_api)
        description('Folder para proyectos de Preguntas Api')
}

//Multibranch para el OTP API
multibranchPipelineJob(validador_otp_api_multibranch) {
    triggers {
        periodic(1)
    }
    branchSources {
        git {
            id('validador-otp-api-id')
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
            id('validador-admin-otp-id')
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
multibranchPipelineJob(preguntas_api_multibranch) {
    triggers {
        periodic(1)
    }
    branchSources {
        git {
            id('preguntas-api-id')
            remote(repo_preguntas_api)
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
                regex(/.*Validador.*Preguntas.*/)
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
