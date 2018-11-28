mydata <-read.csv("/home/data.csv", header=TRUE, sep=",")
print(mydata)
write.csv(mydata, "/home/data_1.csv" ,qoute =T, append = F, row.names = T, col.names=T)
