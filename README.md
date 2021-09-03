SSE Demo
========

Simple demo app that use 'server-sent events'. 

This app was created to be a simple 'straw man' to help debugging issues 
with contour ingress configuration in a k8s cluster.

It is suspected that contour needs some special configuration to properly
support endpoints serving up server-sent events. These endpoints
do not work out of the box and are terminated with a '504 upstream request timed out' 
error.

We think that contour needs to be told explicitly not to 'timeout' such request. 
Perhaps this is done by configuring contour globally, or via some special
annotations on the k8s ingress resources.