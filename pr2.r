mydata <- read.csv("/home/data.csv", header=TRUE, sep=",")
print(mydata)
write.csv(mydata, "/home/data.csv", qoute=T, append=F, row.names=T, col.names=T)

hist(iris$Sepal.Length[1:5])
gra <- density(iris$Sepal.Length[1:5])
plot(gra)
pie(table(iris$Species))
