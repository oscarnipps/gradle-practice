
/*
* Notes :
*
* Gradle is a build configuration tool
*
* Based on the following concepts:
*  - Build configuration
*  - Task and plugins
*  - Dependency management
*  - Build lifecycle
*
* Gradle wrapper (gradlew) is used to run gradle commands via ./gradlew (./ specifies the directory where the wrapper lives i.e .gradle/wrapper/gradle-wrapper.jar)
*
* The gradlew (linux/ mac) and gradle.bat (windows) are used to run the gradle commands instead of using gradle directly
*
* The gradle wrapper :
*  - runs the jar file , resolves and downloads the version of gradle if there is none (the wrapper never upgrades gradle as it always makes use of the version specified)
*  - helps maintain consistent setup across different teams / development environment
*  - no manual gradle installation needed
*  - CI tools need it i.e ./gradlew assembleDebug
*  - ensures AGP compatibility
*
* AGP (android gradle plugin) is a gradle plugin where each AGP version requires a specific gradle version range
*
* Gradle goes through 3 phases when executing a task : Initialization , Configuration and Execution
*
* Initialization Phase :
*  - This is where the settings gradle file is evaluated (Settings model is generated)
*  - The sub-projects that participate in the build are identified and for each sub-project gradle generates a Project model (ProjectDescriptor)
*  - Configurations are also evaluated in this phase (i.e plugin management , dependency resolution e.t.c)
*  -
*
* Settings model generated in the initialization phase represents an internal model by gradle that :
*  - has build-wide info or metadata (project hierarchy , root build e.t.c)
*  - holds plugin and dependency resolution rules
*
* Project model generated in the initialization phase represents an internal model by gradle that :
*  - has project metadata such as the path , name , directory , child or parent relation ships
*
* Configuration phase :
*  - for each project descriptor the actual project instances are created
*  - build scripts of each project is evaluated
*  - tasks structure or graph is generated (which task would be executed after which)
*  - configurations are also evaluated (plugins applied , tasks are registered and dependencies are configured)
*
* Execution phase :
*  - Tasks are executed
*
*/
println("SETTINGS: This is executed during the initialization phase")

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Gradle Practice"
include(":app")

