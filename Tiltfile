allow_k8s_contexts('cltest2')

SOURCE_IMAGE = os.getenv("SOURCE_IMAGE", default='jngacr3.azurecr.io/tap1.1.0/si/spring-sensors')
LOCAL_PATH = os.getenv("LOCAL_PATH", default='/Users/jnagel/jng/app/ztestsjng/tests_TAP/w1/spring-sensors')
NAMESPACE = os.getenv("NAMESPACE", default='envt-dev')

SOURCE_IMAGE = 'jngacr3.azurecr.io/tap1.1.0/appsrcs/spring-sensors'
LOCAL_PATH = '/Users/jnagel/jng/app/ztestsjng/tests_TAP/w1/spring-sensors'
NAMESPACE = 'envt-dev'

k8s_custom_deploy(
    'spring-sensors',
    apply_cmd="tanzu apps workload apply -f config/workload.yaml --live-update" +
               " --local-path " + LOCAL_PATH +
               " --source-image " + SOURCE_IMAGE +
               " --namespace " + NAMESPACE +
               " --yes >/dev/null" +
               " && kubectl get workload spring-sensors --namespace " + NAMESPACE + " -o yaml",
    delete_cmd="tanzu apps workload delete -f config/workload.yaml --namespace " + NAMESPACE + " --yes",
    deps=['pom.xml', './target/classes'],
    container_selector='workload',
    live_update=[
      sync('./target/classes', '/workspace/BOOT-INF/classes')
    ]
)

k8s_resource('spring-sensors', port_forwards=["8080:8080"],
            extra_pod_selectors=[{'serving.knative.dev/service': 'spring-sensors'}])