library(datasets)
car_data = cars
ind_cardata <- sample(1:nrow(cars), 0.8*nrow(cars))
train_cardata <- car_data[ind_cardata,]
test_cardata <- car_data[-ind_cardata,]
head(car_data)
lfit <- lm(dist ~ speed , train_cardata)
test_cardata$dist<-NULL
# predicting for speed =25
df <- data.frame(speed = 25)
lipre <- predict.lm(lfit,df)
print(lipre)
plot(car_data$speed,car_data$dist,xlab = "speed",ylab = "Distance") abline(lfit)
