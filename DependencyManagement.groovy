class DependencyManagement {

    def configureRepositories(dsl) {

        dsl.repositories {
            grailsCentral()
            mavenCentral()

            mavenRepo "https://repo.transmartfoundation.org/content/repositories/public/"

            // -- Genome Browser plugin --
            //   to inclue the plugin, uncomment the following line
            //   and see related comment block below 
            // mavenRepo "https://repo.thehyve.nl/content/repositories/public/"
        }

        dsl.dependencies {
            //compile 'org.apache.httpcomponents:httpcore:4.3.1'
            //compile 'org.apache.httpcomponents:httpmime:4.4'
        }

        dsl.plugins {
            runtime ':smart-r:1.0.RC1-SNAPSHOT'
            compile ':rdc-rmodules:16.1'
            runtime ':transmart-core:16.1'

            /*
            compile (':transmart-gwas:16.1') {
                excludes 'search-domain'
            }
            */

            //// already included in transmart-gwas
            //compile ':transmart-legacy-db:16.1'
            //// already included in transmart-gwas
            //compile ':folder-management:16.1'
            //// already included in transmart-gwas, folder-management
            //compile ':search-domain:16.1'
            //// already included in search-domain, transmart-gwas,
            //                       folder-management
            //compile ':biomart-domain:16.1'
            //// already included in biomart-domain
            //compile ':transmart-java:16.1'
            // -- Genome Browser plugin --
            //   to inclue the plugin, uncomment the following two lines
            //   and see related comment block above 
            runtime ':dalliance-plugin:0.2-SNAPSHOT'
            // runtime ':transmart-mydas:unknown'
            runtime ':transmart-rest-api:16.1'
            runtime ':blend4j-plugin:16.1'
            runtime ':transmart-metacore-plugin:16.1'

            test ':transmart-core-db-tests:16.1'
        }
    }

    def internalDependencies(dsl) {
    }

    def configureInternalPlugin(scope, name) {

    }

    def inlineInternalDependencies(grails, grailsSettings) {
        grails.plugin.location.'folder-management' = "../folder-management-plugin"
    }

}