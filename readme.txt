download latest version o Istio from release page
 - https://github.com/istio/istio/releases/

extract the archive and add its location to PATH env variable

istioctl install --set profile=demo -y

enable sidecars
kubectl label namespace default istio-injection=enabled



Producer:
kubectl run -i --tty load-generator --rm --image=busybox --restart=Never -- /bin/sh -c "while sleep 0.01; do wget -q -O- http://client-service:8080/calculate; done"