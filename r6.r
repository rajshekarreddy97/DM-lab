library(datasets)
library(cluster)
library(factoextra) #install.packages("factoextra") lindata <- iris
lindata$Species<-NULL
d<- scale(dist(lindata,method = "euclidian"))
kfit <- kmeans(d,3)
hfit <- hkmeans(d,3)
fviz_cluster(hfit, lindata, geom = "point") fviz_cluster(kfit, lindata, geom = "point")
