library(reshape2)
library(ggplot2)

results = read.csv("../results/results.csv")
results

ggplot(results) +
  labs(title = "Sample plot", x = "Run", y = "Execution time [s]") +
  geom_point(aes(x = as.factor(Run), y = Time, col = VmArgs, shape = VmArgs), size = 1.5) +
  geom_line(aes(x = as.factor(Run), y = Time, col = VmArgs, group = VmArgs), size = 0.4) +
  facet_wrap(~ Phase, ncol=1) + 
  scale_y_continuous() +
  theme_bw() +
  theme(legend.key = element_blank(), legend.title = element_blank(), legend.position = "bottom")

