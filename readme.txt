download latest version o Istio from release page
 - https://github.com/istio/istio/releases/

extract the archive and add its location to PATH env variable

istioctl install --set profile=demo -y

enable sidecars
kubectl label namespace default istio-injection=enabled



Producer:
kubectl run -i --tty load-generator --rm --image=busybox --restart=Never -- /bin/sh -c "while sleep 0.01; do wget -q -O- http://client-service:8080/calculate; done"

// enable scaling - dont for the apply for the security fix
kubectl autoscale deployment client-service --cpu-percent=50 --min=1 --max=10 --dry-run=client -o yaml > scaler.yaml

kubectl apply -f https://github.com/kubernetes-sigs/metrics-server/releases/latest/download/components.yaml --dry-run=client -o yaml > metrics.server.yaml
kubectl patch deployment metrics-server -n kube-system --type 'json' -p '[{"op": "add", "path": "/spec/template/spec/containers/0/args/-", "value": "--kubelet-insecure-tls"}]'





You might notice that the Pod is not starting because of the following error:
1
"Failed to scrape node" err="Get \"https://192.168.65.4:10250/stats/summary?only_cpu_and_memory=true\": x509: cannot validate certificate for 192.168.65.4 because it doesn't contain any IP SANs" node="docker-desktop"

To fix that error, run the following command:
kubectl patch deployment metrics-server -n kube-system --type 'json' -p '[{"op": "add", "path": "/spec/template/spec/containers/0/args/-", "value": "--kubelet-insecure-tls"}]'
1
$ kubectl patch deployment metrics-server -n kube-system --type 'json' -p '[{"op": "add", "path": "/spec/template/spec/containers/0/args/-", "value": "--kubelet-insecure-tls"}]'
2
deployment.apps/metrics-server patched