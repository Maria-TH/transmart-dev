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
			runtime ':smart-r:16.2-SNAPSHOT'
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
        //new InternalDependenciesFilter(dsl: dsl).with {
		/*
			dsl.compile ':rdc-rmodules:16.1'
            dsl.runtime ':transmart-core:16.1'
            dsl.compile ':transmart-gwas:16.1'
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
            // runtime ':dalliance-plugin:unknown'
            // runtime ':transmart-mydas:unknown'
            dsl.runtime ':transmart-rest-api:16.1'
            dsl.runtime ':blend4j-plugin:16.1'
            dsl.runtime ':transmart-metacore-plugin:16.1'

            dsl.test ':transmart-core-db-tests:16.1'
			*/
        //}
    }

    def configureInternalPlugin(scope, name) {
		
    }
	
    def inlineInternalDependencies(grails, grailsSettings) {
		grails.plugin.location.'folder-management' = "../folder-management-plugin"
    }
/*
    def useSnapshot = false
    def transmartVersion = useSnapshot ? '16.1-SNAPSHOT' : '16.1'
    def inlinePlugins = useSnapshot ? [:] : [
        'transmart-core': 'transmart-core-db',
        'rdc-rmodules': 'Rmodules',
        'folder-management': 'folder-management-plugin',
        'transmart-gwas': 'transmart-gwas-plugin',
        'transmart-gwas-plink': 'transmart-gwas-plink'
    ]

    def configureRepositories(dsl) {
        dsl.repositories {
            grailsCentral()
            mavenCentral()

            //mavenRepo "https://tm-dev.sd.genego.com/artifactory/plugins-snapshot-local/"
            //mavenRepo "https://tm-dev.sd.genego.com/artifactory/plugins-release-local/"
            mavenRepo "https://repo.transmartfoundation.org/content/repositories/public/"
            mavenRepo "https://repo.thehyve.nl/content/repositories/public/"
        }
    }

    class InternalDependenciesFilter {
        def dsl

        def invokeMethod(String name, args) {
            args[0] = args[0].toString()
            def metaMethod = dsl.metaClass.getMetaMethod(name, args)
            if (inlinePlugins.keySet().any { args[0].contains(":${it}:") }) {
                return null
            }
            def result = metaMethod.invoke(dsl, args)
            return result
        }
    }

    def internalDependencies(dsl) {
        new InternalDependenciesFilter(dsl: dsl).with {
            build ':tomcat:7.0.55.3'

            compile ":rdc-rmodules:$transmartVersion"
            runtime ":transmart-core:$transmartVersion"
            compile ":transmart-gwas:$transmartVersion"
            compile ":transmart-gwas-plink:$transmartVersion"
            //// already included in transmart-gwas
            //compile ":transmart-legacy-db:$transmartVersion"
            //// already included in transmart-gwas
            //compile ':folder-management:1.2.4'
            //// already included in transmart-gwas, folder-management
            compile ":search-domain:$transmartVersion"
            //// already included in search-domain, transmart-gwas,
            //                       folder-management
            compile ":biomart-domain:$transmartVersion"
            //// already included in biomart-domain
            compile ":transmart-java:$transmartVersion"
            runtime ':dalliance-plugin:0.2-SNAPSHOT'
            runtime ':transmart-mydas:0.1-SNAPSHOT'
            runtime(":transmart-rest-api:$transmartVersion") {
                excludes 'transmart-core'
                excludes 'transmart-core-db-tests'
            }
            runtime ":blend4j-plugin:$transmartVersion"
            runtime ":transmart-metacore-plugin:$transmartVersion"

            //test ':transmart-core-db-tests:1.2.4'
        }
    }

    def configureInternalPlugin(scope, name) {

    }

    def inlineInternalDependencies(grails, grailsSettings) {
//        	grails.plugin.location."summarystatisticsreport" = "/u01/git/summarystatisticsreport.git"
        def dir = new File(getClass().protectionDomain.codeSource.location.path).parentFile
        def projectsDir = dir.parentFile
        inlinePlugins.entrySet().each { entry ->
            print("Plugin ${entry.key} inlined")
            def pluginPath = new File(projectsDir, entry.value)
            if (!pluginPath.exists()) {
                print("Plugin ${entry.key} wasn't found. Skipping.")
            }
            grails.plugin.location[entry.key] = pluginPath.canonicalPath
        }
    }
	*/
}