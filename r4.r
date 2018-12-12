library(rpart) #install.packages("rpart") library(datasets)
library(e1071) #install.packages("e1071") library(rpart.plot) #install.packages("rpart.plot") str(iris)
ind <- sample(2, nrow(iris),replace = TRUE, prob = c(0.5,0.5)) trainData <- iris[ind ==1,]
testData <- iris[ind ==2,]
my_plot <- rpart( Species ~ Sepal.Length + Sepal.Width + Petal.Length + Petal.Width ,trainData,
                  method = "class")
                  
summary(my_plot)
rpart.plot::rpart.plot(my_plot)
res <- predict(my_plot,testData) table(res,testData$Species)
summary(res)
print(res)
pred <- naiveBayes(Species ~.,data = trainData,laplace = 1) #mosaicplot(pred)
ans <- predict(pred,testData)
table(ans,testData$Species)
summary(ans)
