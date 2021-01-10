validador_otp_api_multibranch = "dev-validador-otp/otp-api"
validador_otp_admin_multibranch = "dev-validador-otp/otp-admin"
validador_otp_admin_conf_api_multibranch = "dev-validador-otp/otp-admin-conf-api"
validador_preguntas_api_multibranch = "dev-validador-preguntas/preguntas-api"

repo_validador_otp_api = "";
repo_validador_otp_admin = "https://github.com/edeleon2408/validador-api-otp.git";
repo_validador_otp_admin_conf_api = "";
repo_validador_preguntas_api = "";

folder_name_validador_otp = "dev-validador-otp"
folder_name_validador_preguntas = "dev-validador-preguntas"

view_name_develop = "Develop"
//view_name_api_preguntas = "Api-preguntas"

//Folder para el Proyecto Validador OTP
folder(folder_name_validador_otp){
        displayName(folder_name_validador_otp)
        description('Folder para proyectos de Validador OTP')
}

//Folder para el Proyecto Api Preguntas
folder(folder_name_validador_preguntas){
        displayName(folder_name_validador_preguntas)
        description('Folder para proyectos de Validador Preguntas Api')
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
multibranchPipelineJob(validador_otp_admin_multibranch) {
    triggers {
        periodic(1)
    }
    branchSources {
        git {
            id('dev-validador-otp-admin-id')
            remote(repo_validador_otp_admin)
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

//Multibranch para OTP Admin Configuración API
multibranchPipelineJob(validador_otp_admin_conf_api_multibranch) {
    triggers {
        periodic(1)
    }
    branchSources {
        git {
            id('dev-validador-otp-admin-conf-api-id')
            remote(repo_validador_otp_admin_conf_api)
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
